SUMMARY = "Image booting to a console"

LICENSE = "MIT"

PV = "1"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"

IMAGE_LINGUAS = "en-us"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

IMAGE_FEATURES_mx6 += " \
    debug-tweaks \
    ssh-server-openssh \
"

#For packagegroup-basic use this instead of sshdropbear
TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

IMAGE_INSTALL += " \
    packagegroup-basic \
    packagegroup-base-extended \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    angstrom-packagegroup-boot \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
    minicom \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    uart-test \
"

IMAGE_INSTALL_tegra3mainline += " \
    libgpiod \
    ntpdate \
    lrzsz \
    lmsensors-sensors \
"

IMAGE_INSTALL_mx6 += " \
    packagegroup-core-full-cmdline-utils \
    packagegroup-base \
    packagegroup-imx-tools-audio \
    ntpdate \
    rng-tools \
    dfu-util \
    openssl-engines \
"
#mx6 machine override using ssh-server-openssh which is not compatible with this packagegroup
IMAGE_INSTALL_remove_mx6 += "packagegroup-basic"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "console-hostmobility-image"

inherit core-image

