import Strategy


class EDF(Strategy):

    tasks = priorityqueue

    def __init__(self, scenario):
        self.name = "EarliestDeadlineFirst"
        for d in scenario.departures:
            #questa parte è comune tra edf e fcfs, però una agisce con gli arrivals e l'altra con le departures
            lul = 1

    def run(self):
        for task in tasks:
            task.execute()
            tasks.dequeue()


