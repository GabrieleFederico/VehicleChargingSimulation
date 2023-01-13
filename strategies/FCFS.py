import queue

from strategies.Strategy import Strategy
from dataclasses import dataclass


def sortByArrival(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.arrival, reverse=True)


class FCFS(Strategy):

    def __init__(self):
        self.name = "FCFS"
        self.time = 0

    def run(self, vehicles, power):
        sortByArrival(vehicles)
        for vehicle in vehicles:
            while not vehicle.isCharged():
                if power <= vehicle.getBattery().chargePower:
                    vehicle.charge(power/60)
                else:
                    vehicle.charge(vehicle.getBattery().chargePower/60)
                self.time += 1
                print(self.time, vehicle.name, vehicle.getBattery().stateOfCharge)
