import re;
import xlsxwriter as xw

workbook = xw.Workbook("dep_tree.xlsx") # 创建工作簿
worksheet1 = workbook.add_worksheet("sheet1") # 创建子表
worksheet1.activate()  # 激活表
title = ['依赖名称', '依赖版本']  # 设置表头
worksheet1.write_row('A1', title) # 从A1单元格开始写入表头

index = 2 # 从第二行开始写入

with open("dep_tree.txt", "r") as f:
	for line in f.readlines():
		line = line.strip("\n")
		pattern = re.compile(r"([@/\-a-z]+)@(\d{1,2}\.\d\.\d(\sdeduped)?)")
		result = re.search(pattern, line)
		if result:
			insertData = [result.group(1), result.group(2)]
			row = 'A' + str(index)
			worksheet1.write_row(row, insertData)
			index += 1
	workbook.close()

