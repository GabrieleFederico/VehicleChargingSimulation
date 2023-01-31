import sys

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
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        self.ui.addVehicleButton.clicked.connect(self.addFrame)
        self.createNewVehicleWidget(0, 0)
        self.show()

    def addFrame(self):
        self.createNewVehicleWidget(0, 0)

    def createNewVehicleWidget(self, rowNumber, columnNumber):
        newName = "frame" + str(rowNumber) + "_" + str(columnNumber)
        self.frame = VehicleWidget()
        self.frame.setObjectName(newName)
        self.frame.setMaximumSize(QSize(350, 150))
        self.frame.setMaximumSize(QSize(350, 150))
        self.ui.gridLayout.addWidget(self.frame, rowNumber, columnNumber, 1, 1, Qt.AlignHCenter | Qt.AlignVCenter)


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
