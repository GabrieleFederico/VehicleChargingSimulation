import threading


class Station:
    def __init__(self, strategy):
        self.components = []
        self.strategy = strategy
        self.vehicles = []
        self.chargePower = 300

    def addVehicle(self,  vehicle):
        self.vehicles.append(vehicle)

    def runStrategy(self):
        t1 = threading.Thread(target=self.run)
        t1.start()

    def run(self):
        self.strategy.run(self.vehicles, self.chargePower)
