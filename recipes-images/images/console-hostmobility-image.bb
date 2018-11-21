SUMMARY = "Image booting to a console"

LICENSE = "MIT"

PV = "V2.8.4"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"

IMAGE_LINGUAS = "en-us"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_INSTALL += " \
    packagegroup-basic \
    packagegroup-base-extended \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-net-minimal \
    angstrom-packagegroup-boot \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
"


IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "console-hostmobility-image"

inherit image

