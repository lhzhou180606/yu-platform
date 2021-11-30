package org.yu.serve.system.module.dept.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yu.common.querydsl.controller.DslBaseApiController;
import org.yu.serve.system.module.dept.domain.DeptTypeDO;
import org.yu.serve.system.module.dept.query.DeptTypeQuery;
import org.yu.serve.system.module.dept.service.DeptTypeService;

/**
 * @author wangxd
 * @date 2020-11-30 17:54
 */
@RestController
@RequestMapping("deptType")
public class DeptTypeController extends DslBaseApiController<DeptTypeService, DeptTypeDO, String> {
    protected DeptTypeController(DeptTypeService deptTypeService) {
        super(deptTypeService);
    }

    @GetMapping("subTypes/{typeId}")
    public ResponseEntity<Object> findSubTypesByTypeId(@PathVariable String typeId) {
        return new ResponseEntity<>(dslBaseService.findSubTypesByTypeId(typeId), HttpStatus.OK);
    }

    @GetMapping("subTypes/deptNo/{deptNo}")
    public ResponseEntity<Object> findSubTypesByDeptNo(@PathVariable String deptNo) {
        return new ResponseEntity<>(dslBaseService.findSubTypesByDeptNo(deptNo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getPages(DeptTypeQuery query, Pageable pageable) {
        return super.query(query, pageable);
    }
}
