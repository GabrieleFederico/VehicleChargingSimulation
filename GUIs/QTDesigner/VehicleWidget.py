# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'VehicleWidget.ui'
##
## Created by: Qt User Interface Compiler version 6.4.1
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QFrame, QLabel, QSizePolicy,
    QTextEdit, QWidget)

class Ui_vehicleWidget(object):
    def setupUi(self, vehicleWidget):
        if not vehicleWidget.objectName():
            vehicleWidget.setObjectName(u"vehicleWidget")
        vehicleWidget.resize(400, 177)
        self.frame = QFrame(vehicleWidget)
        self.frame.setObjectName(u"frame")
        self.frame.setGeometry(QRect(-10, -10, 431, 351))
        self.frame.setFrameShape(QFrame.StyledPanel)
        self.frame.setFrameShadow(QFrame.Raised)
        self.nameTextEdit = QTextEdit(self.frame)
        self.nameTextEdit.setObjectName(u"nameTextEdit")
        self.nameTextEdit.setGeometry(QRect(30, 50, 111, 31))
        self.nameLabel = QLabel(self.frame)
        self.nameLabel.setObjectName(u"nameLabel")
        self.nameLabel.setGeometry(QRect(30, 30, 49, 16))
        self.arrivalTextEdit = QTextEdit(self.frame)
        self.arrivalTextEdit.setObjectName(u"arrivalTextEdit")
        self.arrivalTextEdit.setGeometry(QRect(190, 50, 41, 31))
        self.arrivalLabel = QLabel(self.frame)
        self.arrivalLabel.setObjectName(u"arrivalLabel")
        self.arrivalLabel.setGeometry(QRect(190, 30, 49, 16))
        self.departureLabel = QLabel(self.frame)
        self.departureLabel.setObjectName(u"departureLabel")
        self.departureLabel.setGeometry(QRect(260, 30, 61, 16))
        self.departureTextEdit = QTextEdit(self.frame)
        self.departureTextEdit.setObjectName(u"departureTextEdit")
        self.departureTextEdit.setGeometry(QRect(260, 50, 41, 31))
        self.capacityLabel = QLabel(self.frame)
        self.capacityLabel.setObjectName(u"capacityLabel")
        self.capacityLabel.setGeometry(QRect(30, 100, 49, 16))
        self.capacityTextEdit = QTextEdit(self.frame)
        self.capacityTextEdit.setObjectName(u"capacityTextEdit")
        self.capacityTextEdit.setGeometry(QRect(30, 120, 51, 31))
        self.chargePowerLabel = QLabel(self.frame)
        self.chargePowerLabel.setObjectName(u"chargePowerLabel")
        self.chargePowerLabel.setGeometry(QRect(110, 100, 81, 16))
        self.chargePowerTextEdit = QTextEdit(self.frame)
        self.chargePowerTextEdit.setObjectName(u"chargePowerTextEdit")
        self.chargePowerTextEdit.setGeometry(QRect(110, 120, 51, 31))
        self.socTextEdit = QTextEdit(self.frame)
        self.socTextEdit.setObjectName(u"socTextEdit")
        self.socTextEdit.setGeometry(QRect(220, 120, 51, 31))
        self.SOCLabel = QLabel(self.frame)
        self.SOCLabel.setObjectName(u"SOCLabel")
        self.SOCLabel.setGeometry(QRect(220, 100, 49, 16))
        self.desiredChargeTextEdit = QTextEdit(self.frame)
        self.desiredChargeTextEdit.setObjectName(u"desiredChargeTextEdit")
        self.desiredChargeTextEdit.setGeometry(QRect(300, 120, 51, 31))
        self.desiredChargeLabel = QLabel(self.frame)
        self.desiredChargeLabel.setObjectName(u"desiredChargeLabel")
        self.desiredChargeLabel.setGeometry(QRect(300, 100, 81, 16))

        self.retranslateUi(vehicleWidget)

        QMetaObject.connectSlotsByName(vehicleWidget)
    # setupUi

    def retranslateUi(self, vehicleWidget):
        vehicleWidget.setWindowTitle(QCoreApplication.translate("vehicleWidget", u"Form", None))
        self.nameLabel.setText(QCoreApplication.translate("vehicleWidget", u"Name", None))
        self.arrivalLabel.setText(QCoreApplication.translate("vehicleWidget", u"Arrival", None))
        self.departureLabel.setText(QCoreApplication.translate("vehicleWidget", u"Departure", None))
        self.capacityLabel.setText(QCoreApplication.translate("vehicleWidget", u"Capacity", None))
        self.chargePowerLabel.setText(QCoreApplication.translate("vehicleWidget", u"ChargePower", None))
        self.SOCLabel.setText(QCoreApplication.translate("vehicleWidget", u"SOC", None))
        self.desiredChargeLabel.setText(QCoreApplication.translate("vehicleWidget", u"DesiredCharge", None))
    # retranslateUi

