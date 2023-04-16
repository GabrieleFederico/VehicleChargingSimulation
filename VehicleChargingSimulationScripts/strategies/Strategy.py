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

    def run(self, station):
        sortByArrival(station.waitingVehicles)
        for vehicle in station.waitingVehicles:
            if len(station.chargingVehicles) >= station.maximumChargingVehicles or station.time < vehicle.arrival:
                return
            station.chargingVehicles.append(vehicle)
            station.waitingVehicles.remove(vehicle)
            vehicle.charging = True
            vehicle.startingChargeTime = station.time
            self.assignPriority(station.chargingVehicles)
        return

    def assignPriority(self, vehicles):
        i = 1
        for vehicle in vehicles:
            vehicle.priority = i
            i += 1
