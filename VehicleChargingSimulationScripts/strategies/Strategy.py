import threading

from strategies.utils import sortByArrival


class Strategy:
    name = "StrategyName"

    def __init__(self):
        pass

    def run(self, station):
        pass

    @classmethod
    def parseStrategy(cls, string):
        if string.strip() == "FCFS":
            return FCFS()


class FCFS(Strategy):

    def __init__(self):
        super().__init__()
        self.name = "FCFS"
        self.condition = threading.Condition()

    def run(self, station):
        sortByArrival(station.vehiclesToCharge)
        for vehicle in station.vehiclesToCharge:
            self.condition.acquire()
            while len(station.chargingVehicles) >= station.maximumChargingVehicles or station.time < vehicle.arrival:
                self.condition.notify_all()
                self.condition.wait()
            station.chargingVehicles.append(vehicle)
            vehicle.charging = True
            vehicle.startingChargeTime = station.time
            self.assignPriority(station.chargingVehicles)
            self.condition.notify_all()
            self.condition.release()

    def assignPriority(self, vehicles):
        i = 1
        for vehicle in vehicles:
            vehicle.priority = i
            i += 1
