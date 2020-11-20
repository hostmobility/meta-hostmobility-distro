SUMMARY = "Image booting to a console with development tools"
LICENSE = "MIT"

require console-hostmobility-image.bb


IMAGE_INSTALL += " \
    gdb \
    gdbserver \
    glibc-dbg \
    packagegroup-sdk-target \
    ethtool \
    packagegroup-hostmobility-net-extended \
    pm-utils \
    systemd-analyze \
    hdparm \
    iperf \
    i2c-tools \
    memtester \
    stress \
    lmbench \
    nbench-byte \
    python3-pip \
    python3-pyserial \
"

IMAGE_INSTALL_mx6 += " \
    packagegroup-core-full-cmdline \
"

export IMAGE_DEVELOPNAME = "console-hostmobility-dev-image"



