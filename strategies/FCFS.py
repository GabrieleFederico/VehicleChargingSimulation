import queue
import threading

from entities.Scenario import Scenario
from strategies.Strategy import Strategy
from dataclasses import dataclass

from strategies.utils import sortByArrival


class FCFS(Strategy):

    def __init__(self):
        self.name = "FCFS"
        self.condition = threading.Condition()

    def run(self, station):
        sortByArrival(station.vehicles)

        for vehicle in station.vehicles:
            while len(station.chargingVehicles) >= 2:
                with self.condition:
                    self.condition.wait()
            if len(station.chargingVehicles) < 2:
                while station.time < vehicle.arrival:
                    with self.condition:
                        self.condition.notify_all()
                        self.condition.wait()
                with self.condition:
                    with self.condition:
                        station.chargingVehicles.append(vehicle)
                        self.condition.notify_all()
                    self.assignPriority(station.chargingVehicles)

    def assignPriority(self, vehicles):
        i = 1
        for vehicle in vehicles:
            vehicle.priority = i
            i += 1
