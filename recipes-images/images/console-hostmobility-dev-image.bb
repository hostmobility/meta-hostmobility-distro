SUMMARY = "Image booting to a console with development tools"
LICENSE = "MIT"

require console-hostmobility-image.bb

PV = "V2.8.4"

IMAGE_INSTALL += " \
    gdb \
    gdbserver \
    glibc-dbg \
    packagegroup-sdk-target \
"
export IMAGE_DEVELOPNAME = "console-hostmobility-dev-image"



