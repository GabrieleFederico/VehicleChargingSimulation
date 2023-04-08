def sortByArrival(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.arrival, reverse=False)


def sortByPriority(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.priority, reverse=False)


