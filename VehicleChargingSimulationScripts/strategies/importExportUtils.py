import csv
import json

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
    with open("JSONFiles/scenario.json", "w") as out:
        out.write(jsonObject)
    return


def importFromJson(jsonFile):
    scenario = Scenario("Scenario 1")
    # scenario = json.loads(jsonFile.read(), object_hook=customScenarioDecoder)
    print(scenario)
    """
    for vehicle in vehicles:
        vehiclesList.append(vehicle.toDict())
    jsonObject = json.dumps(vehiclesList, indent=4, )
    with open("JSONFiles/vehicles.json", "w") as out:
        out.write(jsonObject)
    """
    return scenario