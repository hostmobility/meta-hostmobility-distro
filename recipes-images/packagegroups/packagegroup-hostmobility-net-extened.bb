SUMMARY = "Networking package group"
DESCRIPTION = "Package group bringing in packages for a more network manager framework"

inherit packagegroup

PACKAGES = "\
    packagegroup-hostmobility-net-extended \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    modemmanager \
    mobile-broadband-provider-info \
    wvdial \
    networkmanager \
"

