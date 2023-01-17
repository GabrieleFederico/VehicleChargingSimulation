import threading

import Strategy
from strategies.utils import sortByArrival


class EDF(Strategy):

    def __init__(self):
        self.name = "EarliestDeadlineFirst"

    def run(self, station):
        sortByArrival(station.vehicles)
        for vehicle in station.vehicles:
            while len(station.chargingVehicles) >= 2:
                self.condition.wait()
            if len(station.chargingVehicles) < 2:
                threading.Thread(target=station.chargeVehicle(vehicle)).start()
