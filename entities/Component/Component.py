class Component:
    def __init__(self):
        self.name = "ComponentName"


class Battery(Component):
    def __init__(self):
        self.name = "Battery"
        self.capacity = 200
        self.energyRate = .5


class SolarPanel(Component):
    def __init__(self):
        self.name = "SolarPanel"
        self.energyRate = .5
