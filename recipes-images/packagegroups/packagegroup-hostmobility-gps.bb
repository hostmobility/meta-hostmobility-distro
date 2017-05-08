SUMMARY = "GNSS package group"
DESCRIPTION = "Package group bringing in packages needed to support \
Global Navigation Satellite Systems (GNSS)"

inherit packagegroup

PACKAGES = "\
    packagegroup-hostmobility-gps \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    gpsd \
    gps-utils \
    gpsd-conf \
    gpsd-dev \
    gpsd-gpsctl \
    gpsd-udev \
    libgps \
    libgpsd \
    "

