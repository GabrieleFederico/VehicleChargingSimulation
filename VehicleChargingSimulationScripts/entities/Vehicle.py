from entities.Component.Component import Battery


class Vehicle:
    def __init__(self, arrival=0, departure=100, name="car", desiredCharge=80):
        self.name = name
        self.components = {}
        self.arrival = arrival
        self.departure = departure
        self.components["battery"] = Battery(owner=self)
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
        return self.components["battery"]

    def isCharged(self):
        return self.components["battery"].isCharged()

    def addComponent(self, component, name):
        self.components[name] = component

    def charge(self, power):
        self.components["battery"].charge(power)

    def reachedDesiredCharge(self):
        return self.components["battery"].stateOfCharge >= self.desiredCharge

    def toDict(self):
        components = []
        for key, comp in self.components.items():
            components.append(comp.toDict())
        return {"name" : self.name, "arrival" : self.arrival, "departure" : self.departure,
                "desiredCharge" : self.desiredCharge, "components" : components}

