from entities.Component.Component import Battery, Component


class Vehicle:
    def __init__(self, arrival=0, departure=100, name="car", desiredCharge=80):
        self.name = name
        self.components = {}
        self.arrival = arrival
        self.departure = departure
        self.charging = False
        self.startingChargeTime = -1
        self.finishingChargeTime = -1
        self.priority = 0
        self.desiredCharge = desiredCharge
        self.timeToCharge = 0

    def getArrival(self):
        return self.arrival

    def getDeparture(self):
        return self.departure

    def getStateOfCharge(self):
        return self.getBattery().getStateOfCharge()

    def getBattery(self):
        return self.components["Battery"]

    def isCharged(self):
        return self.components["Battery"].isCharged()

    def addComponent(self, component, name):
        component.owner = self
        self.components[name] = component

    def charge(self, power):
        self.components["Battery"].charge(power)

    def reachedDesiredCharge(self):
        return self.components["Battery"].stateOfCharge >= self.desiredCharge

    @classmethod
    def parseVehicle(cls, string):
        vehicle = Vehicle()
        componentsSplit = string.split(",vehicle_components:")
        componentsStrings = componentsSplit[1].split("C-")
        for componentString in componentsStrings:
            if "component_name" in componentString:
                component = Component.parseComponent(componentString)
                vehicle.addComponent(component, component.name)
        attributes = componentsSplit[0].split(",")

        vehicle.name = attributes[0].split(":")[1]
        vehicle.arrival = int(attributes[1].split(":")[1])
        vehicle.departure = int(attributes[2].split(":")[1])
        vehicle.desiredCharge = float(attributes[3].split(":")[1])

        return vehicle

    def toDict(self):
        components = []
        for key, comp in self.components.items():
            components.append(comp.toDict())
        return {"vehicle_name": self.name, "arrival": self.arrival, "departure": self.departure,
                "desired_charge": self.desiredCharge, "vehicle_components": components}
