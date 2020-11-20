SUMMARY = "Host Mobility base package group"
DESCRIPTION = "Package group base applications"

inherit packagegroup

RDEPENDS_${PN} = " \
    libgpiod \
    minicom \
    libssl \
    lrzsz \
    lmsensors-sensors \
    opkg \
    opkg-utils \
    htop \
    make \
"

