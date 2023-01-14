import queue
import threading

from strategies.Strategy import Strategy
from dataclasses import dataclass

from strategies.utils import sortByArrival


class FCFS(Strategy):

    def __init__(self):
        self.name = "FCFS"
        self.time = 0
        self.condition = threading.Condition()

    def run(self, station):
        sortByArrival(station.vehicles)
        for vehicle in station.vehicles:
            while len(station.chargingVehicles) >= 2:
                self.condition.wait()
            if len(station.chargingVehicles) < 2:
                threading.Thread(target=station.chargeVehicle(vehicle)).start()


