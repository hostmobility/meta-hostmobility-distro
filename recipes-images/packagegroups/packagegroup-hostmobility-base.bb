SUMMARY = "Control Area Network package group"
DESCRIPTION = "Package group bringing in packages that are needed when working with CAN on Linux"

inherit packagegroup

RDEPENDS_${PN} = " \
    libgpiod \
    minicom \
    libssl \
    lrzsz \
    lmsensors-sensors \
    python3-pip \
    python3-pyserial \
    opkg \
    opkg-utils \
    htop \
    make \
"

