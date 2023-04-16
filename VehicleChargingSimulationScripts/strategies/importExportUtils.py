import csv
import json
import os
import time

from entities.Scenario import Scenario


def exportToCsvScenarioResult(scenario):
    header = ['Vehicle name', 'Time to charge', 'Waiting Time']
    path = 'CSVFiles/ScenarioResult'+str(round(time.time()*1000))
    os.mkdir(path)
    for station in scenario.stations:
        with open(path+'/'+station.name+'.csv', 'w') as f:
            writer = csv.writer(f, dialect='excel')
            writer.writerow(header)
            for vehicle in station.vehicles:
                #print(vehicle.name, vehicle.arrival, vehicle.departure, vehicle.startingChargeTime, vehicle.finishingChargeTime)
                data = [vehicle.name, vehicle.finishingChargeTime - vehicle.startingChargeTime, vehicle.startingChargeTime - vehicle.arrival]
                writer.writerow(data)


def exportToJson(scenario: Scenario):
    jsonObject = json.dumps(scenario.toDict(), indent=4, )
    with open("JSONFiles/scenario"+str(round(time.time()*1000))+".json", "w") as out:
        out.write(jsonObject)
    return
