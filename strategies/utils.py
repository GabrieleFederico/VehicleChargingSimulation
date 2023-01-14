
def sortByArrival(vehicles):
    vehicles.sort(key=lambda vehicle: vehicle.arrival, reverse=False)
