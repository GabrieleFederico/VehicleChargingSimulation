import threading

from entities.Station import Station
from strategies.importExportUtils import exportToCsvScenarioResult


class Scenario:

    def __init__(self, name):
        self.stations = []
        self.name = name

    def runSimulation(self):
        for station in self.stations:
            station.runStrategy()
        #exportToCsvScenarioResult(self)

    def addStation(self, station):
        self.stations.append(station)

    def getStations(self):
        return self.stations

    def toDict(self):
        stationsDicts = []
        for station in self.stations:
            stationsDicts.append(station.toDict())
        return {"scenario_name": self.name, "stations": stationsDicts}

    @classmethod
    def parseScenario(cls, string):
        scenarioSplitString = string.split("Scen-")
        scenarioSplitString = scenarioSplitString[1].split("scenario_name:")
        scenarioSplitString = scenarioSplitString[1].split(",stations")
        scenario = Scenario(scenarioSplitString[0])
        stationsStrings = scenarioSplitString[1].split("St-")
        for stationString in stationsStrings:
            if "station_name" in stationString:
                scenario.addStation(Station.parseStation(stationString))
        return scenario

