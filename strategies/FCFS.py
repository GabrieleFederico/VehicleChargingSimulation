import Strategy


class FCFS(Strategy):
    def __init__(self, scenario):
        self.name = "FCFS"
        for a in scenario.arrivals:
            tasks.enqueue(a)

