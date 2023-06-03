import threading

from entities.Component.Component import Component
from entities.Vehicle import Vehicle
from strategies.Strategy import Strategy
from strategies.utils import sortByPriority


class Station:
    def __init__(self, name, strategy):
        self.name = name
        self.networkChargePower = 40
        self.components = {}
        self.strategy = strategy
        self.waitingVehicles = []
        self.vehicles = []
        self.availableChargePower = 300
        self.chargingVehicles = []
        self.maximumChargingVehicles = 3
        self.chargingPowers = [0 for _ in range(0, self.maximumChargingVehicles)]
        self.usingBattery = False
        self.time = 0

    def addVehicle(self, vehicle):
        self.waitingVehicles.append(vehicle)
        self.vehicles.append(vehicle)

    def addComponent(self, component, name):
        component.owner = self
        self.components[name] = component

    def runStrategy(self):
        self.chargeVehicles()

    def chargeVehicles(self):
        while len(self.waitingVehicles) > 0:
            while len(self.chargingVehicles) > 0:
                self.assignChargingPower()
                i = 0
                for vehicle in self.chargingVehicles:
                    if (not vehicle.isCharged()) and self.time < vehicle.departure:
                        vehicle.charge(self.chargingPowers[i])
                        i += 1
                    else:
                        vehicle.charging = False
                        vehicle.finishingChargeTime = self.time
                        if vehicle.hasReachedDesiredCharge():
                            vehicle.satisfied = True
                        self.chargingVehicles.remove(vehicle)
                self.time += 1
                self.strategy.run(self)
            if len(self.waitingVehicles) > 0:
                self.time += 1
                self.strategy.run(self)
            self.components["Battery"].charge(self.networkChargePower/60)

    def verifyAvailableChargePower(self):
        if self.components["Battery"].getStateOfCharge() > 20:
            self.availableChargePower = self.components["Battery"].getChargePower()
            self.usingBattery = True
        else:
            self.availableChargePower = self.networkChargePower
            self.usingBattery = False

    def assignChargingPower(self):
        self.verifyAvailableChargePower()
        sortByPriority(self.chargingVehicles)
        for i in range(0, len(self.chargingVehicles)):
            if self.availableChargePower <= self.chargingVehicles[i].getBattery().getChargePower():
                self.chargingPowers[i] = self.availableChargePower / 60
                self.availableChargePower -= self.availableChargePower
                if self.usingBattery:
                    self.components["Battery"].charge(-self.chargingPowers[i])
            else:
                self.chargingPowers[i] = self.chargingVehicles[i].getBattery().getChargePower() / 60
                self.availableChargePower -= self.chargingVehicles[i].getBattery().getChargePower()
                if self.usingBattery:
                    self.components["Battery"].charge(-self.chargingPowers[i])


    @classmethod
    def parseStation(cls, string):
        firstSplit = string.split(",vehicles:")
        nameSplit = firstSplit[0].split("station_name:")
        secondSplit = firstSplit[1].split(",station_components:")
        vehiclesStrings = secondSplit[0].split("V-")
        thirdSplit = secondSplit[1].split(",strategy:")
        attributes = thirdSplit[1].split(",")
        station = Station(nameSplit[1], Strategy.parseStrategy(attributes[0]))
        station.maximumChargingVehicles = int(attributes[1].split(":")[1])
        station.chargingPowers = [0 for _ in range(0, station.maximumChargingVehicles)]
        for vehicleString in vehiclesStrings:
            if "vehicle_name" in vehicleString:
                station.addVehicle(Vehicle.parseVehicle(vehicleString))
        componentsStrings = thirdSplit[0].split("C-")
        for componentString in componentsStrings:
            if "component_name" in componentString:
                component = Component.parseComponent(componentString)
                station.addComponent(component, component.name)
        return station

    def toDict(self):
        componentsDicts = []
        for compName, comp in self.components.items():
            componentsDicts.append(comp.toDict())
        vehiclesDicts = []
        for vehicle in self.waitingVehicles:
            vehiclesDicts.append(vehicle.toDict())
        return {"station_name": self.name, "vehicles": vehiclesDicts, "station_components": componentsDicts,
                "max_vehicles": self.maximumChargingVehicles, "strategy": self.strategy.name}

