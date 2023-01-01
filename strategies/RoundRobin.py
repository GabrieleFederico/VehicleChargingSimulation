import Strategy


class RoundRobin(Strategy):
    tasks = queue()

    def __init__(self, scenario):
        self.name = "RoundRobin"
        self.scenario = scenario

    def run(self):
        while tasks.head() is not None:
            task = tasks.heasanddequeue()
            while time < 5:
                task.execute()
            if not task.finished():
                tasks.enqueue(task)



