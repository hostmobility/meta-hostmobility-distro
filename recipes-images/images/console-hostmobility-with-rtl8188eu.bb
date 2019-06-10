SUMMARY = "Image including rtl8188eu wifi drivers"
LICENSE = "MIT"

require console-hostmobility-image.bb

PV = "V1.0.0"

IMAGE_INSTALL += " \
    wifi-rtl8188eu \
"
export IMAGE_DEVELOPNAME = "console-hostmobility-with-rtl8188eu"



