DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-debug \
    tools-profile \
    splash \
    ssh-server-openssh \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base', \
                                                       '', d), d)} \
"

LICENSE = "MIT"

require console-hostmobility-image.bb

X11TOOLS = "\
    x11perf \
    xrestop \
    xwininfo \
    xprop \
"

IMAGE_INSTALL_append += " \
    packagegroup-core-full-cmdline \
    packagegroup-hostmobility-base \
    packagegroup-hostmobility-net-extended \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-tools-gpu \
    packagegroup-imx-tools-audio \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', "${X11TOOLS}", "", d)} \
"

export IMAGE_BASENAME = "mobility-image"