SUMMARY = "Control Area Network package group"
DESCRIPTION = "Package group bringing in packages that are needed when working with CAN on Linux"

inherit packagegroup

PACKAGES = "\
    packagegroup-hostmobility-can \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    can-utils \
    libsocketcan \
    iproute2 \
"

