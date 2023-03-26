import threading


class Scenario:

    def __init__(self, name):
        self.stations = []
        self.name = name

    def runSimulation(self):
        for station in self.stations:
            threading.Thread(target=station.runStrategy()).start()

    def addStation(self, station):
        self.stations.append(station)

    def getStations(self):
        return self.stations

    def toDict(self):
        stationsDicts = []
        for station in self.stations:
            stationsDicts.append(station.toDict())
        return {"name": self.name, "stations": stationsDicts}

