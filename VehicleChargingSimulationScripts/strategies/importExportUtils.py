import csv
import json
import time

from entities.Scenario import Scenario


def exportToCsvScenarioResult():
    header = ['Number of cars', 'Mean time to charge', 'Time to finish']
    data = ['test1', 'test2', 'test3']
    with open('CSVFiles/ScenarioResult.csv', 'w') as f:
        writer = csv.writer(f, dialect='excel')
        writer.writerow(header)
        writer.writerow(data)


def exportToJson(scenario: Scenario):
    jsonObject = json.dumps(scenario.toDict(), indent=4, )
    with open("JSONFiles/scenario"+str(round(time.time()*1000))+".json", "w") as out:
        out.write(jsonObject)
    return
