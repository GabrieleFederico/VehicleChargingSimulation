import csv


def sortByArrival(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.arrival, reverse=False)


def sortByPriority(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.priority, reverse=False)


def exportToCsvScenarioResult():
    header = ['Number of cars', 'Mean time to charge', 'Time to finish']
    data = ['']
    with open('CSVFiles/ScenarioResult.csv', 'w') as f:
        writer = csv.writer(f, dialect='excel')
        writer.writerow(header)
        writer.writerow(data)
