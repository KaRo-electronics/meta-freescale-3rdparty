# Copyright (C) 2017 Oliver Wendt OW@KARO-electronics.de
# Released under the MIT license (see COPYING.MIT for the terms)
# 
SUMMARY = "Ka-Ro electronics 4.13 Kernel"
DESCRIPTION = "Linux Kernel (mainline) for Ka-Ro electronics TX6 Computer-On-Modules."
SECTION = "kernel"
LICENSE = "GPLv2"

PROVIDES = "virtual/kernel"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "karo-tx6-mainline"
LOCALVERSION = "-karo-tx6"
SRCREV = "fa9db474ab1eb96c3df55238eacf659efea9ae48"
KERNEL_SRC = "git://github.com/karo-electronics/karo-tx-linux;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
"

KERNEL_IMAGETYPE="uImage"

COMPATIBLE_MACHINE  = "(tx6[qsu]-.*|txul-.*)"

