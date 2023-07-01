from strategies.utils import sortByArrival, sortByDeparture


class Strategy:
    name = "ALL"

    def __init__(self):
        pass

    def run(self, station):
        sortByArrival(station.waitingVehicles)
        for vehicle in station.waitingVehicles:
            if len(station.chargingVehicles) < station.maximumChargingVehicles and station.time >= vehicle.arrival:
                station.chargingVehicles.append(vehicle)
                station.waitingVehicles.remove(vehicle)
                vehicle.charging = True
                vehicle.startingChargeTime = station.time
        self.assignPriority(station.chargingVehicles)
        return

    @classmethod
    def parseStrategy(cls, string):
        if string.strip() == "FCFS":
            return FCFS()
        if string.strip() == "EDF":
            return EDF()
        if string.strip() == "RR":
            return RR()
        if string.strip() == "ALL":
            return Strategy()

    def assignPriority(self, chargingVehicles):
        pass


class FCFS(Strategy):

    def __init__(self):
        super().__init__()
        self.name = "FCFS"

    def run(self, station):
        super().run(station)

    def assignPriority(self, vehicles):
        i = 1
        for vehicle in vehicles:
            vehicle.priority = i
            i += 1


class EDF(Strategy):

    def __init__(self):
        super().__init__()
        self.name = "EDF"

    def run(self, station):
        super().run(station)

    def assignPriority(self, vehicles):
        sortByDeparture(vehicles)
        i = 1
        for vehicle in vehicles:
            vehicle.priority = i
            i += 1


class RR(Strategy):

    def __init__(self):
        super().__init__()
        self.name = "RR"
        self.priorities = []

    def run(self, station):
        if len(self.priorities) == 0:
            self.priorities = [x for x in range(1, station.maximumChargingVehicles+1)]
        super().run(station)

    def assignPriority(self, vehicles):
        for i in range(0, len(vehicles)):
            vehicles[i].priority = self.priorities[i]
        if self.priorities[0] == 1:
            self.rotatePriorities()

    def rotatePriorities(self):
        last = self.priorities[len(self.priorities) - 1]
        for i in range(len(self.priorities) - 1, 0, -1):
            self.priorities[i] = self.priorities[i-1]
        self.priorities[0] = last
