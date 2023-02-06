import sys
from pydoc import text

from PySide6 import QtCore
from PySide6.QtCore import QSize, Qt
from PySide6.QtWidgets import QFrame, QWidget
from PySide6.QtWidgets import QApplication, QMainWindow
from GUIs.QTDesigner.MainWindow import Ui_MainWindow
from GUIs.QTDesigner.VehicleWidget import Ui_vehicleWidget


class VehicleWidget(QWidget):
    def __init__(self):
        super(VehicleWidget, self).__init__()
        self.ui = Ui_vehicleWidget
        self.ui.setupUi(self.ui, self)


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.widgets = []
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        self.ui.addVehicleButton.clicked.connect(self.addFrame)
        self.show()

    def addFrame(self):
        self.createNewVehicleWidget()

    def createNewVehicleWidget(self):
        self.widget = VehicleWidget()
        self.widget.setParent(self.ui.scrollAreaWidgetContents)
        self.widget.setObjectName(u"widget")
        self.widgets.append(self.widget)
        self.ui.listView.addWidget(self.widget)

if __name__ == "__main__":
    app = QApplication(sys.argv)

    window = MainWindow()
    window.show()

    sys.exit(app.exec())

# if __name__ == '__main__':
#    app = QApplication(sys.argv)
#    ex = MainWindow()
#    exportToCsvScenarioResult()
#    sys.exit(app.exec_())
