import csv
import json
import os
import time


def exportToCsvScenarioResult(scenario):
    header = ['Vehicle name', 'Time to charge', 'Waiting Time', 'Satisfied']
    path = 'CSVFiles/ScenarioResult'+str(round(time.time()*1000))
    os.mkdir(path)
    for station in scenario.stations:
        with open(path+'/'+station.name+'.csv', 'w') as f:
            writer = csv.writer(f, dialect='excel')
            writer.writerow(header)
            for vehicle in station.vehicles:
                data = [vehicle.name, vehicle.finishingChargeTime - vehicle.startingChargeTime, vehicle.startingChargeTime - vehicle.arrival, vehicle.satisfied]
                writer.writerow(data)


def exportToJson(scenario):
    jsonObject = json.dumps(scenario.toDict(), indent=4, )
    with open("JSONFiles/scenario"+str(round(time.time()*1000))+".json", "w") as out:
        out.write(jsonObject)
    return
