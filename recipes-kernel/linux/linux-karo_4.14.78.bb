SUMMARY = "Linux Kernel provided and supported by NXP inc. Ka-Ro patchset"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU. \
This subversion also includes a set of patches for the Ka-Ro TX8M solution."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-imx-src-${PV}.inc

# Ka-Ro specific patch set for NXP's linux-imx 4.14.78 1.0.0 ga
SRC_URI += " \
	    file://0001-drm-panel-simple-Add-support-for-Tianma-TM101JVHG32-.patch \
	    file://0002-ARM64-dts-add-support-for-Ka-Ro-electronics-TX8M-161.patch \
	    file://0003-mfd-bd71837-select-missing-features-for-BD71837-PMIC.patch \
	    file://0004-regulator-bd71837-prevent-warning-when-compiled-with.patch \
	    file://0005-soc-imx-select-missing-PM_GENERIC_DOMAINS-for-i.MX8-.patch \
	    file://0006-ARM64-dts-imx8mm-tx8m-1610-disable-arm-idle.patch \
	    file://0007-karo-tx8m-enable-PCIe-support-for-LM511-WLAN-module.patch \
	    file://0008-ARM64-dts-imx8mm-add-missing-bus-range-property-to-p.patch \
"

# Ka-Ro specific Device Tree files to be compiled
KERNEL_DEVICETREE_append = "freescale/imx8mm-tx8m-1610.dtb "
KERNEL_DEVICETREE_append = "freescale/imx8mm-tx8m-1610-mipi-mb.dtb "

# Ka-Ro specific Kernel config to be used for compiling
KERNEL_DEFCONFIG = "${KERNEL_SRC}/arch/arm64/configs/tx8m_defconfig"

COMPATIBLE_MACHINE  = "(tx8m.*)"
