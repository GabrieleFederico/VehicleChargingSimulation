from entities.Component.Component import Component


class Battery(Component):

    def __init__(self):
        self.name = "battery"
        # percentage (preferrably between 20 and 80)
        self.stateOfCharge = 20
        # kWh
        self.capacity = 70
        self.chargePower = 130

    def charge(self, power):
        currentCharge = self.capacity / 100 * self.stateOfCharge
        if currentCharge + power >= self.capacity:
            self.stateOfCharge = 100
        else:
            self.stateOfCharge = (currentCharge + power)*100/self.capacity

        return

    def isCharged(self):
        return self.stateOfCharge >= 80
