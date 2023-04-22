def sortByArrival(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.arrival, reverse=False)


def sortByDeparture(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.departure, reverse=False)


def sortByPriority(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.priority, reverse=False)
