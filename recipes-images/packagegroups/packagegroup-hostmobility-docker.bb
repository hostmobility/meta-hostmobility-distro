SUMMARY = "Docker package group"
DESCRIPTION = "Add support for docker"

inherit packagegroup

PACKAGES = "\
    packagegroup-hostmobility-docker \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    docker \
    "

