import threading


class Station:
    def __init__(self, strategy):
        self.components = []
        self.strategy = strategy
        self.vehicles = []
        self.maxChargePower = 300
        self.availableChargePower = 300
        self.chargingVehicles = []
        self.maximumChargingVehicles = 2
        self.time = 0

    def addVehicle(self,  vehicle):
        self.vehicles.append(vehicle)

    def runStrategy(self):
        t1 = threading.Thread(target=self.run)
        t1.start()

    def run(self):
        self.strategy.run(self)

    def chargeVehicle(self, vehicle):
        self.strategy.condition.acquire()
        self.chargingVehicles.append(vehicle)
        self.strategy.condition.release()
        while not vehicle.isCharged():
            if self.availableChargePower <= vehicle.getBattery().getChargePower():
                vehicle.charge(self.availableChargePower/60)
            else:
                vehicle.charge(vehicle.getBattery().getChargePower()/60)
            self.strategy.time += 1
            print(self.strategy.time, vehicle.name, vehicle.getBattery().stateOfCharge)

        self.strategy.condition.acquire()
        self.chargingVehicles.remove(vehicle)
        self.strategy.condition.notify_all()
        self.strategy.condition.release()
