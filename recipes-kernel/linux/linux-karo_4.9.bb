# Copyright (C) 2015, 2017 O.S. Systems Software LTDA.
# Copyright (C) 2018 Ka-Ro electronics GmbH, Oliver Wendt OW@KARO-electronics.de
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP i.MX Linux kernel with backported features and fixes"

DESCRIPTION = "Linux kernel based on NXP 4.9-2.3.x IMX release, used by FSL \
Community BSP in order to provide support for i.MX based platforms and \
include official Linux kernel stable updates, backported features and fixes \
coming from the vendors, kernel community or FSL Community itself."

require recipes-kernel/linux/linux-imx.inc
# require recipes-kernel/linux/linux-dtb.inc

include linux-fslc.inc

#PV .= "+git${SRCPV}"

SRCBRANCH = "4.9-2.3.x-imx"
SRCREV = "ded0ac8f40f9561d8ab2f8ef6c9ff8dc435f2b41"

KERNEL_SRC = "git://github.com/Freescale/linux-fslc.git"
FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}/patches:${THISDIR}/${BP}:"

SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
           file://0001-patch-for-edt-m12.diff \
           file://0002-karo-tx6-dts.diff \
           file://imx6qdl-tx6-mb7-sound.patch \
           file://txul-phy-reset.patch \
"

LOCALVERSION = "-tx6"
#FILESEXTRAPATHS_prepend = "${THISDIR}/${BP}/txbase/${TXBASE}:"

DEPENDS += "lzop-native bc-native"

# Add NXP binary blob driver for the Vivante GPU to the kernel image.
# Otherwise settings in the Kernel defconfig are actively delete or ignored and
# the required external LKM ([RFS]/lib/modules/<kernel-version>/extra) is not
# available at all ( exception being if specific images are being "bitbaked"
# like: fsl-image-multimedia-full )

# Add Vivante GPU driver support
# Handle Vivante kernel driver setting:
#   0 - machine does not have Vivante GPU driver support
#   1 - machine has Vivante GPU driver support
MACHINE_HAS_VIVANTE_KERNEL_DRIVER_SUPPORT ?= "1"

# Use Vivante kernel driver module:
#   0 - enable the builtin kernel driver module
#   1 - enable the external kernel module
MACHINE_USES_VIVANTE_KERNEL_DRIVER_MODULE ?= "1"

# Ka-Ro DT added
DEFAULT_DEVICETREE_imx6dl-tx6-emmc ?= " \
                                  imx6dl-tx6dl-comtft.dtb \
                                  imx6dl-tx6s-8035.dtb \
                                  imx6dl-tx6s-8035-mb7.dtb \
                                  imx6dl-tx6s-8135.dtb \
                                  imx6dl-tx6s-8135-mb7.dtb \
                                  imx6dl-tx6u-8033.dtb \
                                  imx6dl-tx6u-8033-mb7.dtb \
                                  imx6dl-tx6u-8133.dtb \
                                  imx6dl-tx6u-8133-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6dl-tx6-nand ?= " \
                                  imx6dl-tx6s-8034.dtb \
                                  imx6dl-tx6s-8134-mb7.dtb \
                                  imx6dl-tx6s-8034.dtb \
                                  imx6dl-tx6s-8134-mb7.dtb \
                                  imx6dl-tx6u-801x.dtb \
                                  imx6dl-tx6u-811x.dtb \
                                  imx6dl-tx6u-80xx-mb7.dtb \
                                  imx6dl-tx6u-81xx-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6q-tx6-emmc ?= " \
                                  imx6q-tx6q-1020.dtb \
                                  imx6q-tx6q-1020-comtft.dtb \
                                  imx6q-tx6q-1036.dtb \
                                  imx6q-tx6q-1036-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6q-tx6-nand ?= " \
                                  imx6q-tx6q-1010.dtb \
                                  imx6q-tx6q-1110.dtb \
                                  imx6q-tx6q-1010-comtft.dtb \
                                  imx6q-tx6q-10x0-mb7.dtb \
                                  imx6q-tx6q-11x0-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6qp-tx6-emmc ?= " \
                                  imx6qp-tx6qp-8037.dtb \
                                  imx6qp-tx6qp-8137-mb7.dtb \
                                  imx6qp-tx6qp-8037.dtb \
                                  imx6qp-tx6qp-8137-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6ul-tx6-emmc ?= " \
                                  imx6ul-tx6ul-0011.dtb \
                                  imx6ul-txul-5011-mainboard.dtb \
                                  imx6ul-txul-5011-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6ul-tx6-nand ?= " \
                                  imx6ul-tx6ul-0010.dtb \
                                  imx6ul-txul-5010-mainboard.dtb \
                                  imx6ul-txul-5010-mb7.dtb \
"
DEFAULT_DEVICETREE_imx6ull-txul-emmc ?= " \
                                  imx6ull-txul-8013.dtb \
                                  imx6ull-txul-8013-mainboard.dtb \
                                  imx6ull-txul-8013-mb7.dtb \
"

KERNEL_DEVICETREE ?= "${DEFAULT_DEVICETREE}"


DEFAULT_PREFERENCE = "1"

KERNEL_IMAGETYPE = "uImage"

#COMPATIBLE_MACHINE  = "(tx6[qsu]-.*|txul-.*|imx6.*-tx.*)"
#COMPATIBLE_MACHINE  = "(tx6[qus]-.*)"
COMPATIBLE_MACHINE = "(mx6|mx7)"
