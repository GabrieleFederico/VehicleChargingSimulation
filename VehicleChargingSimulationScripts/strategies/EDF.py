import threading

from strategies.Strategy import Strategy
from strategies.utils import sortByArrival


class EDF(Strategy):

    def __init__(self):
        self.name = "EarliestDeadlineFirst"

    def run(self, station):
        sortByArrival(station.waitingVehicles)
        for vehicle in station.waitingVehicles:
            while len(station.chargingVehicles) >= 2:
                self.condition.wait()
            if len(station.chargingVehicles) < 2:
                threading.Thread(target=station.chargeVehicle(vehicle)).start()
