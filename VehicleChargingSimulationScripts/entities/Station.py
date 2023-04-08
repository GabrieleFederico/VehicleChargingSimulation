import threading

from entities.Component.Component import Component
from entities.Vehicle import Vehicle
from strategies.Strategy import Strategy, FCFS
from strategies.utils import sortByPriority


class Station:
    def __init__(self, name, strategy):
        self.name = name
        self.components = {}
        self.strategy = strategy
        self.vehicles = []
        self.maxChargePower = 300
        self.availableChargePower = 300
        self.chargingVehicles = []
        self.maximumChargingVehicles = 3
        self.chargingPowers = [0 for _ in range(0, self.maximumChargingVehicles)]
        self.time = 0

    def addVehicle(self, vehicle):
        self.vehicles.append(vehicle)

    def addComponent(self, component, name):
        component.owner = self
        self.components[name] = component

    def runStrategy(self):
        threading.Thread(target=self.run).start()

    def run(self):
        t1 = threading.Thread(target=self.strategy.run, args=(self,), name="T1")
        t2 = threading.Thread(target=self.chargeVehicles, name="T2")
        t1.start()
        t2.start()

    def chargeVehicles(self):
        while len(self.vehicles) > 0:
            while len(self.chargingVehicles) > 0:
                self.assignChargingPower()
                i = 0
                for vehicle in self.chargingVehicles:
                    if (not vehicle.isCharged()) and self.time < vehicle.departure:
                        vehicle.charge(self.chargingPowers[i])
                        i += 1
                    else:
                        self.strategy.condition.acquire()
                        vehicle.charging = False
                        vehicle.finishingChargeTime = self.time
                        vehicle.timeToCharge = vehicle.finishingChargeTime - vehicle.startingChargeTime
                        self.chargingVehicles.remove(vehicle)
                        self.vehicles.remove(vehicle)
                        self.strategy.condition.notify_all()
                        self.strategy.condition.release()
                    print(self.time, vehicle.name, vehicle.getBattery().stateOfCharge, self.availableChargePower,
                          vehicle.startingChargeTime, vehicle.finishingChargeTime)
                with self.strategy.condition:
                    self.time += 1
                    if len(self.chargingVehicles) < self.maximumChargingVehicles and 1 < len(self.vehicles) != len(
                            self.chargingVehicles):
                        self.strategy.condition.notify_all()
                        self.strategy.condition.wait()
            with self.strategy.condition:
                if len(self.vehicles) > 1:
                    self.time += 1
                    self.strategy.condition.notify_all()
                    self.strategy.condition.wait()
        self.collectResult()

    def assignChargingPower(self):
        sortByPriority(self.chargingVehicles)
        for i in range(0, len(self.chargingVehicles)):
            if self.availableChargePower <= self.chargingVehicles[i].getBattery().getChargePower():
                if self.chargingPowers[i] <= i:
                    self.chargingPowers[i] = self.availableChargePower / 60
                    self.availableChargePower -= self.availableChargePower
            else:
                if self.chargingPowers[i] <= i:
                    self.chargingPowers[i] = self.chargingVehicles[i].getBattery().getChargePower() / 60
                    self.availableChargePower -= self.chargingVehicles[i].getBattery().getChargePower()

    @classmethod
    def parseStation(cls, string):
        firstSplit = string.split(",vehicles:")
        nameSplit = firstSplit[0].split("station_name:")
        secondSplit = firstSplit[1].split(",station_components:")
        vehiclesStrings = secondSplit[0].split("V-")
        thirdSplit = secondSplit[1].split(",strategy:")
        station = Station(nameSplit[1], Strategy.parseStrategy(thirdSplit[1]))
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
        for vehicle in self.vehicles:
            vehiclesDicts.append(vehicle.toDict())
        return {"station_name": self.name, "vehicles": vehiclesDicts, "station_components": componentsDicts}

    # TODO: Should these 3 methods be here or in a Result class? Or maybe in the Scenario class?
    # Or maybe in the result class which should be an attribute of Scenario?

    def collectResult(self):
        self.totalSimulationResult()
        self.perVehicleResult()

    def totalSimulationResult(self):
        pass

    def perVehicleResult(self):
        pass
