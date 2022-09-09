DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."


LICENSE = "MIT"

IMAGE_FEATURES += " \
    debug-tweaks \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
    ssh-server-openssh \
"

X11TOOLS = "\
    x11perf \
    xrestop \
    xwininfo \
    xprop \
"




PV = "1"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"

IMAGE_LINGUAS = "en-us"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@oe.utils.conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

#For packagegroup-basic use this instead of sshdropbear
TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

IMAGE_INSTALL += " \
    packagegroup-hostmobility-net-extended \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagegroup-xfce-base', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
    packagegroup-base-extended \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-can \
    packagegroup-hostmobility-net-minimal \
    packagegroup-hostmobility-gps \
    angstrom-packagegroup-boot \
    udev-extra-rules \
    ${ROOTFS_PKGMANAGE_PKGS} \
    minicom \
    uart-test \
    packagegroup-core-full-cmdline-utils \
    packagegroup-basic \
    packagegroup-imx-tools-audio \
    ntpdate \
    rng-tools \
    dfu-util \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    openssl-engines \
"

#mx6 machine override using ssh-server-openssh which is not compatible with this packagegroup
IMAGE_INSTALL_remove_mx6 += "packagegroup-basic"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

inherit core-image
export IMAGE_BASENAME = "mobility-image"