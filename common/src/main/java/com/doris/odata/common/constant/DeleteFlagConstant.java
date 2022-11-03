package com.doris.odata.common.constant;

/**
 * @author: origindoris
 * @Title: DeleteFlagConstant
 * @Description:
 * @date: 2022/11/2 19:14
 */
public class DeleteFlagConstant {
    public static final String DELETE_FIELD = "deleteFlag";

    public static final String NO = "0";

    public static final String YES = "1";

    public static final String WHERE = DeleteFlagConstant.DELETE_FIELD + " = '" + DeleteFlagConstant.NO + "'";
}
