SUMMARY = "Linux Kernel for Ka-Ro electronics TX Computer-On-Modules"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx_4.1.15_1.0.0_ga"
LOCALVERSION = "-tx6"
SRCREV = "77f61547834c4f127b44b13e43c59133a35880dc"
FILESEXTRAPATHS_prepend = "${THISDIR}/${BP}/txbase/${TXBASE}:"

# Add patches for gcc 6 compiler issue
SRC_URI += "file://gcc6_integrate_fix.patch \
	    file://bcmhd_gcc6_indent_warning_error_fix.patch \
	    file://gpu-viv_gcc6_indent_warning_error_fix.patch \
	   "

# Add Ethernet patches
SRC_URI += "file://reset_ethernet_phy_whenever_the_enet_out_clock_is_being_enabled.patch \
	    file://set-enet_ref_clk-to-50-mhz.patch \
	   "

# Add patch for EDT M12 touchscreen
SRC_URI += "file://add-support-for-edt-m12-touch.patch \
	   "

# Add TX6 module kernel default config(s)
SRC_URI += "file://defconfig \
	   "

# Add TX6 module specific DT file(s)
SRC_URI += "file://imx6qdl-tx6.dtsi;subdir=git/arch/arm/boot/dts \
	    file://imx6qdl-tx6-gpio.h;subdir=git/include/dt-bindings/gpio \
	   "

# Add baseboard dtsi file(s)
SRC_URI += "file://txbase-${TXBASE}.dtsi;subdir=git/arch/arm/boot/dts"

# Add TX6 (machine) specific DTS file(s)
SRC_URI += "file://${TXTYPE}-${TXNVM}-${TXBASE}.dts;subdir=git/arch/arm/boot/dts"

KERNEL_DEVICETREE = "${TXTYPE}-${TXNVM}-${TXBASE}.dtb"

DEFAULT_PREFERENCE = "1"

KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE  = "(tx6[qus]-.*)"
