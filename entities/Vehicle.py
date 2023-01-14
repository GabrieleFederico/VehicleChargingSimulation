from entities.Component.Component import Battery


class Vehicle:
    def __init__(self, arrival=0, departure=100, name="car"):
        self.name = name
        self.components = {}
        self.arrival = arrival
        self.departure = departure
        self.components["battery"] = Battery(owner=self)
        self.charging = False

    def getArrival(self):
        return self.arrival

    def getDeparture(self):
        return self.departure

    def getStateOfCharge(self):
        return self.getBattery().getStateOfCharte()

    def getBattery(self):
        return self.components["battery"]

    def isCharged(self):
        return self.components["battery"].isCharged()

    def addComponent(self, component, name):
        self.components[name] = component

    def charge(self, power):
        self.components["battery"].charge(power)
