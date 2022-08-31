SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"

inherit packagegroup

RDEPENDS_${PN} = " \
    libgpiod \
    libgpiod-tools \
    minicom \
    libssl \
    lrzsz \
    lmsensors-sensors \
    opkg \
    opkg-utils \
    htop \
    make \
"

