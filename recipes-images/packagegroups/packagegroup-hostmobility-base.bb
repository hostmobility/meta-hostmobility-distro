SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"

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

